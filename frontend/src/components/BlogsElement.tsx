import {Blogs} from "../services/modelBlogs";
import {deletePost, editPost, fetchAllBlogs} from "../services/apiServices";
import {useState} from "react";

interface BlogProps{
    blog: Blogs

}

export  default  function BlogsElement(props: BlogProps){

    const [isEditing, setIsEditing] = useState(false);
      const [editContent, setEditContent] = useState('');


    const deleteBlog = () => {
        deletePost("id")
            .then(() =>fetchAllBlogs())

    }

    const editBlog = () => {
        editPost().then()
    }

    return(
    <div>
        <div>
           <h3>{props.blog.author}</h3>
        </div>
        <div>
            {props.blog.content}
        </div>
        <div>
            {isEditing ?( <div>
                {props.blog.content}
            </div>)}

            {isEditing ? (<button onClick={() => setIsEditing(false)}>update</button>):
            (<button onClick={() => setIsEditing(true)}>Edit</button>)}
            <button onClick={deleteBlog}>Delete</button>
        </div>
    </div>
    )
}