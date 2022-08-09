import Navigation from "../components/Navigation";
import {FormEvent, useCallback, useEffect, useState} from "react";
import {createPost, fetchAllBlogs} from "../services/apiServices";
import {Blogs} from "../services/modelBlogs";
import BlogsElement from "../components/BlogsElement";
import "./Blog.scss"



export default function Blog() {
    const [author, setAuthor] = useState('');
    const [content, setContent] = useState('');
    const [error, setError] = useState(false);
    const [blogs, setBlogs] = useState<Array<Blogs>>([]);

const fetchBlogs = useCallback(() => {
    fetchAllBlogs()
        .then((blogsFromDB: Array<Blogs>) => setBlogs(blogsFromDB))
}, [])


    useEffect(() => {
        fetchBlogs()
    }, [fetchBlogs])




    const blogsElement = blogs.map(blog => <BlogsElement blog={blog}  fetchBlog={fetchBlogs}/>)

    const submitForm = (ev: FormEvent) => {
        ev.preventDefault();
        createPost({
            author: author, content: content
        }).then(
            () => {
                setAuthor('');
                setContent('');
            }
        ).then(() =>fetchAllBlogs()
            .then((blogsFromDB: Array<Blogs>) => setBlogs(blogsFromDB)))


        if (content.length < 5) {
            setError(true);
        } else {
            setError(false);
        }

    };

    return (
        <div>
            <Navigation/>
            <div className = "blog">
            <h1>Blog</h1>
            <form onSubmit={submitForm}>
                {/*<input type="text" value={author} onChange={ev => setAuthor(ev.target.value)}
                       placeholder="enter your name please"/>*/}
                <textarea value={content} onChange={ev => setContent(ev.target.value)}
                          placeholder="in which country were you last time?
    how was your travel experience?
    what do you think about this country?
    which places can you recommend for excursions?"
                          cols={40} rows={10}
                          style={{border: error ? "1px solid red" : "1px solid blue"}}>

    </textarea>
                {error && <p>please enter a minimum of 5 characters</p>}
                <input type="submit" value="Save"/>
            </form>

            <div>
                {blogsElement}

            </div>
            </div>
        </div>

    )
}

