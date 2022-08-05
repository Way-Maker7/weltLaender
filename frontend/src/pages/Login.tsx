import {FormEvent, useState} from "react";
import "./Login.scss";
import {loginUser} from "../services/apiServices";
import {useNavigate} from "react-router";
import {Link} from "react-router-dom";

export default function Login(){

    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [errorMessage, setErrorMessage] = useState("");
    const nav = useNavigate();


    const login = (ev:FormEvent) => {
        ev.preventDefault();
        loginUser({username, password})
            .then(loginResponse => localStorage.setItem('jwt', loginResponse.jwt))
            .then(() => nav('/blog'))
            .catch(() => setErrorMessage('Login failed'))

    }

    return(
        <div className= "login">
            <h1>Login</h1>
            <h3>you don't have an Account? <Link to="/register">you can register here!!!</Link></h3>
            <form onSubmit={login}>
                <input type="text" value={username} onChange={ev => setUsername(ev.target.value)} placeholder= "Username"/>
                <input type="password" value={password} onChange={ev => setPassword(ev.target.value)} placeholder="Password"/>
                <input type="submit" value="Login"/>
                {errorMessage && <div>{errorMessage}</div>}
            </form>

        </div>
    )
}