import {FormEvent, useState} from "react";
import "./Register.scss";



export default function Register(){

    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [passwordRepeat, setPassordRepeat] = useState("");

const register = (ev: FormEvent) => {
    ev.preventDefault();
}

    return(
        <div className="register">
            <h1>Get an Account</h1>
            <form onSubmit={register}>
                <input type="text" value={username} onChange={ev => setUsername(ev.target.value)} placeholder= "Username"/>
                <input type="password" value={password} onChange={ev => setPassword(ev.target.value)} placeholder="Password"/>
                <input type="password" value={passwordRepeat} onChange={ev => setPassordRepeat(ev.target.value)} placeholder= "Repeat the password"/>
                <input type="submit" value="Register"/>
            </form>
        </div>
    )
}