import React,{useState,useEffect} from 'react'

import NavBar from "./Components/NavBar.jsx"
import Home from "./Pages/Home.jsx"
import Service from "./Pages/Service.jsx"
import Profile from "./Pages/Profile.jsx"
import LoginSignup from './Components/LoginSignup.jsx'

import PrivateRoute from './Components/PrivateRoute.jsx'


import { BrowserRouter,Routes,Route } from 'react-router-dom'

export default function App() {

  let [userData,setUserData] = useState({});
  let [logedIn,setLoggedIn] = useState(false);
  let [loading , setLoading] = useState(true);





  useEffect(()=>{
    let data = localStorage.getItem("userData");
    if(data){
      setUserData(JSON.parse(data));
      setLoggedIn(true);
    } 
  },[]);

  return (
    <div>
      <BrowserRouter>
        <NavBar logedIn={logedIn} />
        <Routes>
          <Route path="/" element={<Home/>}/>
          <Route path="/Service" element={
            <PrivateRoute logedIn={logedIn}>
              <Service/>
            </PrivateRoute>
          }/>
          <Route path="/auth" element={<LoginSignup setLoggedIn={setLoggedIn} setUserData={setUserData} />}/>
          <Route path="/profile" element={
            <PrivateRoute logedIn={logedIn}>
              <Profile/>
            </PrivateRoute>
          }/>
        </Routes>
      </BrowserRouter>
    </div>
  )
}
