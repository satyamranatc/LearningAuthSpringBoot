import React from 'react'
import axios from 'axios'

export default function LoginSignup({setLoggedIn,setUserData}) {

    async function handleLogin(e) {
        e.preventDefault();

        let Data = {
            email : e.target[0].value,
            password : e.target[1].value
        }

        let Res = await axios.post("http://localhost:8080/api/auth/login",Data);

        if(Res.data.status == "Success"){
            setLoggedIn(true);
            localStorage.setItem("userData",JSON.stringify(Res.data.data));
            setUserData(Res.data.data);
        }
        else{
            alert("Something went wrong!");
        }
    }
    async function handleSignup(e) {
        e.preventDefault();

        let Data = {

            fullName : e.target[0].value,
            avatar: e.target[1].value,
            email : e.target[2].value,
            password : e.target[3].value
        }

        let Res = await axios.post("http://localhost:8080/api/auth/signup",Data);

        if(Res.data.status == "Success"){
            setLoggedIn(true);
            localStorage.setItem("userData",JSON.stringify(Res.data.data));
            setUserData(Res.data.data);
        }
        else{
            alert("Something went wrong!");
            
        }
    }

  return (
    <div>
        <center>
            <h1>LoginSignup</h1>
        </center>
        <hr />
        <div id="FormSection" className='flex gap-10 justify-between p-28' >
            <div id = "LoginForm">
                <form className='border-2 border-indigo-400 p-3'>
                    <input className='border-1 border-indigo-400 px-2 py-4 w-2/3' type="text" placeholder='Email/Username' />
                    <input className='border-1 border-indigo-400 px-2 py-4 w-2/3' type="password" placeholder='Password' />
                    <br />
                    <br />
                    <button className='px-3 py-1 rounded rounded-6 bg-indigo-400' >Login</button>
                </form>

            </div>
            <div id = "SignupForm" >


      <form className='border-2 border-indigo-400 p-3'>
                    <input className='border-1 border-indigo-400 px-2 py-4 w-2/3' type="password" placeholder='Full Name' />
                    <input className='border-1 border-indigo-400 px-2 py-4 w-2/3' type="password" placeholder='Avtar' />
                    <input className='border-1 border-indigo-400 px-2 py-4 w-2/3' type="text" placeholder='Email/Username' />
                    <input className='border-1 border-indigo-400 px-2 py-4 w-2/3' type="password" placeholder='Password' />
                    <br />
                    <br />
                    <button className='px-3 py-1 rounded rounded-6 bg-indigo-400' >Sign Up</button>
                </form>

            </div>

        </div>
    </div>
  )
}
