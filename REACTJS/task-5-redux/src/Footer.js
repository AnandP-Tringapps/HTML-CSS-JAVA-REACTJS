import React from 'react'
import {useDispatch, useSelector} from 'react-redux';
export default function Footer() {
const initialvalue = useSelector(state => state);

const dispatch = useDispatch();
  return (
    <div id='footer' class="footer">
    <h2>{initialvalue[1]}</h2>
    </div>
  )
}
