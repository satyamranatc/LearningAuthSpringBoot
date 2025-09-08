import React from 'react'
import { Link,Navigate } from 'react-router-dom'

export default function NavBar() {
  return (
    <nav className='bg-black text-white flex items-center justify-between px-4 py-2'>
        <h2 className='text-2xl font-bold' >Logo</h2>
        <ul className=' flex items-center justify-between gap-2'>
            <li className='active:text-indigo-500' ><Link to="/">Home</Link></li>
            <li className='active:text-indigo-500' ><Link to="/Service">Service</Link></li>
            <li className='active:text-indigo-500' ><Link to="/profile">Profile</Link></li>
        </ul>

    </nav>
  )
}
