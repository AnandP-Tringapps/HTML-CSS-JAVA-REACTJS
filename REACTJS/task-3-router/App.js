import { Outlet, Link } from "react-router-dom";
import '../src/pages/style.css';
function App(){
  return (
    < div>
  
      <nav id='nav'>
          
          <h3>
            <Link id="navigation" to="/">Home</Link> &nbsp;| &nbsp;
          
            <Link id="navigation" to="/About">About</Link> &nbsp;| &nbsp;
          
            <Link id="navigation" to="/contact">Contact</Link>
          </h3>
       
      </nav>
      
      <Outlet />
    </div>
  )
}; 

export default App;