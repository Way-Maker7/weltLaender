import axios, {AxiosResponse} from "axios";
import {Blogs} from "./modelBlogs";
import {userCreationData} from "./modelUser";
import {LoginData, LoginResponse} from "./modelLogin";

export const registerUser = (userCreationData: userCreationData) =>{
    return axios.post('/api/users', userCreationData)
}

export const loginUser = (loginData: LoginData) => {
    return axios.post('/api/auth/login', loginData)
        .then((response: AxiosResponse<LoginResponse>) => response.data)
}

export function fetchAllBlogs(){
    return axios.get('/api/blog', {
        headers:{
            Authorization: `Bearer ${localStorage.getItem('jwt')}`
        }
    })
        .then((response:AxiosResponse<Array<Blogs>>) => response.data)
}

export function createPost(blogs: Blogs){
   return  axios.post('/api/blog', blogs, {
       headers:{
           Authorization: `Bearer ${localStorage.getItem('jwt')}`
       }
   })

}

export function deletePost(id: string){
    return axios.delete(`/api/blog/${id}`,{
        headers:{
            Authorization: `Bearer ${localStorage.getItem('jwt')}`
        }
    })
}

export function editPost(id: string, content: string, author: string){
    return axios.put(`/api/blog`, {
        id,
        author,
        content
    },{
        headers:{
            Authorization: `Bearer ${localStorage.getItem('jwt')}`
        }
    })
}

export function updatePost(id: string){
    return axios.put(`/api/blog/${id}`)
}