import React from 'react'
import { Navigate } from 'react-router-dom'

export default function PrivateRoute({children,logedIn}) {
  return (
    logedIn ? children : <Navigate to="/auth"/>
  )
}
