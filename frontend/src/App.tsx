import React from 'react';
import {BrowserRouter, Routes, Route} from "react-router-dom";
import Home from "./pages/Home";
import './App.scss';
import Blog from "./pages/Blog";
import Register from "./pages/Register";
import Login from "./pages/Login";


function App() {


    return (
       <BrowserRouter>
           <Routes>
               <Route path="/" element={<Login />}></Route>
               <Route path={'/register'} element={<Register/>}></Route>
               <Route path="/home" element={<Home />}></Route>
               <Route path="/blog" element={<Blog />}></Route>
           </Routes>
       </BrowserRouter>
    );
}

export default App;
