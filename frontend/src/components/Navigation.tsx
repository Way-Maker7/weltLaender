import {NavLink} from "react-router-dom";

export default function Navigation(){

    return(
        <div>
            <ul>
                <NavLink to="/home">
                    <li>home</li>
                </NavLink>

                <NavLink to="/blog">
                    <li>blog</li>
                </NavLink>
            </ul>
        </div>
    )
}