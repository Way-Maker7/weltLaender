import {NavLink} from "react-router-dom";
import "./Navigation.scss"

export default function Navigation(){

    return(
        <div className="navigation">
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