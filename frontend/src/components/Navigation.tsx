import {NavLink} from "react-router-dom";

export default function Navigation(){

    return(
        <div>
            <ul>
                <NavLink to="/home">
                    <li>home</li>
                </NavLink>

                <NavLink to="/login">
                    <li>login</li>
                </NavLink>
            </ul>
        </div>
    )
}