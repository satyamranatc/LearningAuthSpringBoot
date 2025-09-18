import React, { useEffect } from 'react'
import axios from "axios"

export default function Service({token}) {

  useEffect(()=>{
    async function getData() {
      let res = axios.get("http://localhost:8080/api/movies/list",{
        headers:{
          "Authorization" : `Bearer ${token}`
        }
      });
      console.log(res.data);
    }
  },[])

  return (
    <div>
        <center>
            <h1>Service</h1>
        </center>
    </div>
  )
}
