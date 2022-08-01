import {Blogs} from "../services/modelBlogs";
import {deletePost, editPost} from "../services/apiServices";
import {useEffect, useState} from "react";
import "./BlogsElement.scss";

interface BlogProps{
    blog: Blogs
    fetchBlog: Function


}

export  default  function BlogsElement(props: BlogProps){

    const [isEditing, setIsEditing] = useState(false);
    const [editContent, setEditContent] = useState('');



    useEffect( () => {setEditContent(props.blog.content)},[props.blog.content])

    const deleteBlog = () => {
        if(props.blog.id){
            deletePost(props.blog.id)
                .then(() =>props.fetchBlog())
        }


    }

    const editBlog = () => {
        editPost(props.blog.id!, editContent, props.blog.author).then(
            () => setIsEditing(false)
        ).then(() => props.fetchBlog())
    }

    return(
    <div className = "articles">
        <div className = "Header">
           <h3>{props.blog.author}</h3>
        </div>
        <div className = "textarea">

            {isEditing ? <div>
                <textarea value={editContent} onChange={ev => setEditContent(ev.target.value)}
                          placeholder="in which country were you last time?
    how was your travel experience?
    what do you think about this country?
    which places can you recommend for excursions?"
                />


            </div>: <div>{props.blog.content}</div>}
        </div>
        <div className = "button">
            {isEditing ? (<button onClick={editBlog}>Update</button>):
            (<button onClick={() => setIsEditing(true)}>Edit</button>)}
            <button onClick={deleteBlog}>Delete</button>
        </div>
    </div>
    )
}