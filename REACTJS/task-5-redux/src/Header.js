import React from 'react'
import {useSelector} from 'react-redux';

export default function Header({appState,updateValue}) {
const initialvalue = useSelector(state => state);
  return (
    <div class="header"> 
        <h2>{initialvalue[0]}</h2>

    </div>
  )
}