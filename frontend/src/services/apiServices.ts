import axios, {AxiosResponse} from "axios";
import {Blogs} from "./modelBlogs";

export function fetchAllBlogs(){
    return axios.get('http://localhost:8080/api/blog')
        .then((response:AxiosResponse<Array<Blogs>>) => response.data)
}

export function createPost(blogs: Blogs){
   return  axios.post('http://localhost:8080/api/blog', blogs)

}

export function deletePost(id: string){
    return axios.delete(`http://localhost:8080/api/blog/${id}`)
}

export function editPost(){
    return axios.put()
}