import {Country} from "../model";
import "./GalleryItems.css"

export interface GalleryItemsProps {
    country: Country
}


export default function GalleryItems(props: GalleryItemsProps) {

    return (
        <div className="Items">
            <div>
                {props.country.translations.deu.common} <br/>
                {"Capital : " + props.country.capital} <br/>
                {/*{"Language " + props.country.languages}<br/>*/}
                {"Population " + props.country.population}<br/><br/>
               <ul> <li><img src={props.country.flags.png} alt="flage"/></li></ul>


                {/*<ul><li>{props.country.flag}</li></ul>*/}
            </div>
        </div>
    )
}