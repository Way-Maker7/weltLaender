import {FormEvent, useState} from "react";
import "./Login.scss";

export default function Login(){

    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");

    const login = (ev:FormEvent) => {
        ev.preventDefault();
    }

    return(
        <div className= "login">
            <h3>Login</h3>
            <form onSubmit={login}>
                <input type="text" value={username} onChange={ev => setUsername(ev.target.value)} placeholder= "Username"/>
                <input type="password" value={password} onChange={ev => setPassword(ev.target.value)} placeholder="Password"/>
                <input type="submit" value="Login"/>
            </form>

        </div>
    )
}