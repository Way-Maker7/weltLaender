import {useEffect, useState} from "react";
import axios from "axios";
import {Country} from "../model";
import GalleryItems from "./GalleryItems";
import "./GalleryItems.css"


export default function Gallery(){


        const [countries, setCountries] = useState<Array<Country>>([])

    const [rangeValue, setRangeValue] = useState("3")

    const names = countries.slice(0, parseInt(rangeValue)).map((c => <GalleryItems country={c}/>))




    useEffect( () => {

        axios.get("https://restcountries.com/v3.1/all")
            .then(response => setCountries(response.data))

    }, [])

    return(
        <div className= "Gallery">
            <h1>Countries</h1>
            <br/>
                <input type= "range" min= "1" max = "250" defaultValue={rangeValue}
                       onChange={(e) => setRangeValue(e.target.value)}/>
            <br/>
            <br/>

            <div>{names}</div>
        </div>
    )
}