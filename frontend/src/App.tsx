import React from 'react';
import {BrowserRouter, Routes, Route} from "react-router-dom";
import Home from "./pages/Home";
import Blog from "./pages/Blog";

function App() {


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
