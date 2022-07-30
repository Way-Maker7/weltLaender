import {NavLink} from "react-router-dom";
import "./Navigation.scss"

export default function Navigation(){

    return(
        <div className="navigation">
            <ul>
                <NavLink to="/home" className={(nav) => (nav.isActive ? "nav-active": "")}>
                    <li>home</li>
                </NavLink>

                <NavLink to="/blog" className={(nav) => (nav.isActive ? "nav-active": "")}>
                    <li>blog</li>
                </NavLink>
            </ul>
        </div>
    )
}