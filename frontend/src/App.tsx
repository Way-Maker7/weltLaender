import React, {useEffect, useState} from 'react';
import {BrowserRouter, Routes, Route} from "react-router-dom";
import Home from "./pages/Home";
import Blog from "./pages/Blog";
import './App.css';
import {Blogs} from "./services/modelBlogs";
import {fetchAllBlogs} from "./services/apiServices";


function App() {
    const [author, setAuthor] = useState<Array<Blogs>>([]);

    useEffect(() => {
        fetchAllBlogs()
            .then((blogsFromDB: Array<Blogs>) => setAuthor(blogsFromDB))
    },[])

    return (
       <BrowserRouter>
           <Routes>
               <Route path="/" element={<Home />}></Route>
               <Route path="/home" element={<Home />}></Route>
               <Route path="/blog" element={<Blog />}></Route>
           </Routes>
       </BrowserRouter>
    );
}

export default App;
