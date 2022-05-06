import React from 'react'
import {useDispatch, useSelector} from 'react-redux';

export default function NavBar() {
  const initialvalue = useSelector(state => state);
  const dispatch = useDispatch();
  return (
    <div id="navbar">
      <h2>NavBar</h2>
      <p>Content- 1</p>
      <p>Content- 2</p>
      <p>Content- 3</p>
    </div>

  )
}
