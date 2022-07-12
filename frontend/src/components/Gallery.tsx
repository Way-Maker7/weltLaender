import {useEffect, useState} from "react";
import axios from "axios";
import {Country} from "../model";
import GalleryItems from "./GalleryItems";



export default function Gallery(){

    {/*
        const [countries, setCountries] = useState([])*/
    }


        const [countries, setCountries] = useState<Array<Country>>([])

    const names = countries.map((c => <GalleryItems country={{ cca2: c.cca2, name: c.name}}/>))

    {/*
        const names = countries.map((c) => (<div>{c.name.common}</div>))*/
    }


    useEffect( () => {

        axios.get("https://restcountries.com/v3.1/all")
            .then(response => setCountries(response.data))
        {/*.
            then(response => console.log(response.data))
        */}
    }, [])

    return(
        <div>
            <h1>Countries</h1>
            {/* <div>{countries.map((c) => (<div>{c.currencies.name}</div>))}</div>*/}
            <div>{names}</div>
        </div>
    )
}