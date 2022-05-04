import { useState } from "react";
import "./app.css";
import FormInput from "./components/FormInput";

const App = () => {
  const [values, setValues] = useState({
    username: "",email: "", password: "",confirmPassword: "",
  });

  const inputs = [
    {
      name: "username",type: "text",placeholder: "Username",errorMessage:"Username should be 3-15 characters ",label: "Username",required: true,
    },
    {  
      name: "email",type: "email",placeholder: "Email",errorMessage: "It should be a valid email address!",label: "Email",
    },
  
    { 
      name: "password",type: "password",placeholder: "Password",errorMessage:"Password should be 4-8 characters",label: "Password",pattern: `[a-zA-Z0-9!@#$%^&*]{4,8}$`,
    },
    { 
      name: "confirmPassword",type: "password",placeholder: "Confirm Password",errorMessage: "Passwords don't match!",label: "Confirm Password",pattern: values.password,
    },
  ];

 
  const handleSubmit = (e) => {
    e.preventDefault();
    alert("Details Submitted Successfully!!")
  };

  const onChange = (e) => {
    setValues({ ...values, [e.target.name]: e.target.value });
  };

  return (
    <div className="app">
      <form onSubmit={handleSubmit} >
        <h1>Register</h1>
        {inputs.map((input) => (
          <FormInput
            key={input.id}
            {...input}
            value={values[input.name]}
            onChange={onChange}
          />
        ))}
        <button>Submit</button>
      </form>
    </div>
  );
};

export default App;
