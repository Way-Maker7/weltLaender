import Navigation from "../components/Navigation";
import {FormEvent, useState} from "react";
import {createPost} from "../services/apiServices";


export default function Blog() {
    const [author, setAuthor] = useState('');
    const [content, setContent] = useState('');
    const [error, setError] = useState(false);

    const submitForm = (ev: FormEvent) => {
        ev.preventDefault();
        createPost({  author: author, content: content
    }).then(
            () =>{
                setAuthor('');
                setContent('');
            }
        )


        if (content.length < 5) {
            setError(true);
        } else {
            setError(false);
        }

    };

    return (
        <div>
            <Navigation/>
            <h1>Blog</h1>
            <form onSubmit={submitForm}>
                <input type="text" value={author} onChange={ev => setAuthor(ev.target.value)}
                       placeholder="enter your name please"/>
                <br/>
                <br/>
                <textarea value={content} onChange={ev => setContent(ev.target.value)}
                          placeholder="in which country were you last time?
    how was your travel experience?
    what do you think about this country?
    which places can you recommend for excursions?"
                          cols={40} rows={10}
                          style={{border: error ? "1px solid red" : "1px solid blue"}}>

    </textarea>
                {error && <p>please enter a minimum of 5 characters</p>}
                <br/>
                <input type="submit" value="Save"/>
            </form>

                <div>
                    <h3>{author}</h3>
                    <p>{content}</p>
                    <div>
                        <button>Edit</button>
                        <button>Delete</button>
                    </div>
                </div>

        </div>

    )
}

