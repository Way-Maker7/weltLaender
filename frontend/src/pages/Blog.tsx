import Navigation from "../components/Navigation";


export default function Blog() {

    const handleSubmit = (e) => {
        e.preventDefault();
    };

    return (
        <div>
            <Navigation/>
            <h1>Blog</h1>
            <form onSubmit={(e) => handleSubmit(e)}>
                <input type="text" placeholder="enter your name please"/>
                <br/>
                <br/>
                <textarea placeholder="in which country were you last time?
    how was your travel experience?
    what do you think about this country?
    which places can you recommend for excursions?"
                          cols={40} rows={10}>

    </textarea>
                <br/>
                <input type="submit" value="send"/>
            </form>
            <ul></ul>
        </div>

    )
}

