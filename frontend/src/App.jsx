import React from 'react'

import NavBar from "./Components/NavBar.jsx"
import Home from "./Pages/Home.jsx"
import Service from "./Pages/Service.jsx"
import Profile from "./Pages/Profile.jsx"


import { BrowserRouter,Routes,Route } from 'react-router-dom'

export default function App() {
  return (
    <div>
      <BrowserRouter>
        <NavBar/>
        <Routes>
          <Route path="/" element={<Home/>}/>
          <Route path="/Service" element={<Service/>}/>
          <Route path="/profile" element={<Profile/>}/>
        </Routes>
      </BrowserRouter>
    </div>
  )
}
