
export interface Country {
    translations: Translations;
    flags: Flags;
    capital: string;
    population: string;
    continents: Array<string>;
    cca2?: string;
    flag?: string;


}

interface Translations {
    deu: DE;
    /*eng: ENG;*/

}

interface DE {
    common: string;
    official: string;
}

interface Flags {
    svg: string;
    png: string;
}
/*
interface ENG {
    common: string;
    official: string;
}*/





