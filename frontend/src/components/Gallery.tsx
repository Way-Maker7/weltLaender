import {useEffect, useState} from "react";
import axios from "axios";
import {Country} from "../model";
import GalleryItems from "./GalleryItems";
import "./Gallery.scss"


export default function Gallery() {


    const [countries, setCountries] = useState<Array<Country>>([])

    const [rangeValue, setRangeValue] = useState("7")


    const radios = ["Africa", "Asia", "Europe", "Oceania", "North America", "South America"]

    const [radio, setRadio] = useState("Europe");

    const names = countries.filter((c) => c.continents.includes(radio)).slice(0, parseInt(rangeValue)).map((c =>
        <GalleryItems country={c}/>))


    useEffect(() => {

        axios.get("https://restcountries.com/v3.1/all")
            .then(response => setCountries(response.data))

    }, [])

    return (
        <div className="Gallery">
            <h1>Countries</h1>
            <ul className="radio">
            <input type="range" min="1" max="250" defaultValue={rangeValue}
                   onChange={(e) => setRangeValue(e.target.value)}/>
            {
                radios.map((continents) => <li><input type="radio" id={continents} name="radioInput"
                                                       defaultValue={radio}
                                                       checked={radio === continents} onChange={(e) =>
                    setRadio(e.target.id)}/>
                    <label htmlFor={continents}>{continents}</label></li>)
            }
            </ul>

            <ul>{names}</ul>

        </div>
    )
}