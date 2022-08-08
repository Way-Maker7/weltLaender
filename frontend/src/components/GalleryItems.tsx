import {Country} from "../model";
import "./GalleryItems.scss"

export interface GalleryItemsProps {
    country: Country
}


export default function GalleryItems(props: GalleryItemsProps) {

    return (
        <li className="Items">
            <img src={props.country.flags.png} alt="flag"/>
            <div className="ItemsInfos">
               <h2> {props.country.translations.deu.common} </h2>
                <h4>{"Capital : " + props.country.capital}</h4>
               <p>Pop. {props.country.population.toLocaleString()}</p>
            </div>
        </li>
    )
}