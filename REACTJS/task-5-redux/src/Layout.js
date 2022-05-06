import React from 'react'
import Content from './Content'
import Footer from './Footer'
import Header from './Header'
import NavBar from './NavBar'
import {createStore} from 'redux'
import { Provider } from 'react-redux'
import appReducer from './Reducer'

const store=createStore(appReducer)
export default function Layout() {


  return (
    <Provider store={store}>
    <div className="layout">
      
    <Header/>
    <div id="content">
      <NavBar/>
      <Content/>
    </div>
    <Footer/>
    </div>
    </Provider>
  )
}


