import {Blogs} from "../services/modelBlogs";

interface BlogProps{
    blog: Blogs
}

export  default  function BlogsElement(props: BlogProps){
    return(
    <div>
        <div>
           <h3>{props.blog.author}</h3>
        </div>
        <div>
            {props.blog.content}
        </div>
        <div>
            <button>Edit</button>
            <button>Delete</button>
        </div>
    </div>
    )
}