import logo from './logo1.svg';
import './App.css';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          BMW United Kingdom
        </p>
        <a
          className="App-link"
          href="https://www.bmw.co.uk/en/index.html"
          target="_blank"
          rel="noopener noreferrer"
        >
         Click Here
        </a>
      </header>
    </div>
  );
}

export default App;
