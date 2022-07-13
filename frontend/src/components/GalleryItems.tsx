import {Country} from "../model";

export interface GalleryItemsProps {
    country: Country
}


export default function GalleryItems(props: GalleryItemsProps) {

    return (
        <div>
            <div>
                {props.country.translations.deu.common} <br/>
                {"Capital : " + props.country.capital} <br/>
                {/*{"Language " + props.country.languages}<br/>*/}
                {"Population " + props.country.population}<br/><br/>
                <li><img src={props.country.flags.png} alt="flage"/></li>


                {/*<ul><li>{props.country.flag}</li></ul>*/}
            </div>
        </div>
    )
}