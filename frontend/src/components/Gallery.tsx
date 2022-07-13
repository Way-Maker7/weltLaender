import {useEffect, useState} from "react";
import axios from "axios";
import {Country} from "../model";
import GalleryItems from "./GalleryItems";



export default function Gallery(){


        const [countries, setCountries] = useState<Array<Country>>([])

    const names = countries.map((c => <GalleryItems country={c}/>))



    useEffect( () => {

        axios.get("https://restcountries.com/v3.1/all")
            .then(response => setCountries(response.data))

    }, [])

    return(
        <div>
            <h1>Countries</h1>

            <div>{names}</div>
        </div>
    )
}