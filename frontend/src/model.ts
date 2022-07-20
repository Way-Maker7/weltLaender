import {keyboard} from "@testing-library/user-event/dist/keyboard";

export interface Country {
    translations: Translations;
    flags: Flags;
    capital: string;
    languages: any;
    population: string;
    cca2?: string;
    flag?: string;


}

interface Translations {
    deu: DE;


}

interface DE {
    common: string;
    official: string;
}

interface Flags {
    svg: string;
    png: string;
}

{/*
    interface Languages {
        [key: string]: string;
    }*/
}


