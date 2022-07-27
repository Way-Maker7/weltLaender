import axios, {AxiosResponse} from "axios";
import {Blogs} from "./modelBlogs";

export function fetchAllBlogs(){
    return axios.get('http:8080/api/blog')
        .then((response:AxiosResponse<Array<Blogs>, any>) => response.data)
}

export function createPost(blogs: Blogs){
   return  axios.post('http://localhost:8080/api/blog', blogs)

}