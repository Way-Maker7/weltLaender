import Navigation from "../components/Navigation";
import {FormEvent} from "react";
import Article from "../components/Article";



export default function Blog() {

    const submitForm = (ev: FormEvent) => {
        ev.preventDefault();
    };

    return (
        <div>
            <Navigation/>
            <h1>Blog</h1>
            <form onSubmit={submitForm}>
                <input type="text" placeholder="enter your name please" />
                <br/>
                <br/>
                <textarea  placeholder="in which country were you last time?
    how was your travel experience?
    what do you think about this country?
    which places can you recommend for excursions?"
                          cols={40} rows={10}>

    </textarea>
                <br/>
                <input type="submit" value="Save"/>
            </form>
            <ul><Article/></ul>
        </div>

    )
}

