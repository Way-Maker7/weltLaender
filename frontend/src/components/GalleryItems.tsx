import {Country} from "../model";

export interface GalleryItemsProps{
    country: Country
}

export default function GalleryItems(props: GalleryItemsProps){

    return(
        <div>
            {/*<ul>
                <li>{props.country.cca2}</li>
            </ul>*/}
            <div>
                {props.country.translations.deu.common}
            </div>
        </div>
    )
}