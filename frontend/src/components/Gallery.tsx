import {useEffect, useState} from "react";
import axios from "axios";



export default function Gallery(){

    const[countries, setCountries] = useState([])

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
            <div>{countries.map((c) => (<div>{c.translations.deu.common}</div>))}</div>
        </div>
    )
}