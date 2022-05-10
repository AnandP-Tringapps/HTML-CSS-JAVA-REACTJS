import React, { useState } from 'react';
import './App.css';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import Paper from '@mui/material/Paper';
import { v4 as uuidv4 } from 'uuid';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import Card from '@mui/material/Card';
import CardMedia from '@mui/material/CardMedia';
import CardContent from '@mui/material/CardContent';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select from '@mui/material/Select';



function App() {

  const [carname, setcarName] = useState();
  const [model, setModel] = useState();
  const [price, setPrice] = useState();
  const [type, setType] = useState();
  const [description, setDescription] = useState();
  const [crudDetails, setCrudDetails] = useState([]);
  const [status, setStatus] = useState("add");
  const [id, setId] = useState("")

  const submit = () => {
   
    if(carname, model, price, type, description){
      if (status === "add"){

        let formDetails = {
        id:uuidv4(),
        carname, model, price, type, description
        }
        setCrudDetails([...crudDetails, formDetails])

      } else if (status==="edit") {
        let editCard = crudDetails.filter(data => data.id != id)
        let editCards ={
          id, carname, model, price, type, description
        }
        setCrudDetails([...editCard, editCards])
      }

      setcarName("")
      setModel("")
      setPrice("")
      setType("")
      setDescription("")
      setStatus("add")
    }
     else
    {
      alert("Enter All Values")
    }

    
  }
   const deleteCards = (id) => {
    let deleteCard = crudDetails.filter(data=> (data.id != id))
    setCrudDetails(deleteCard)
  }

  const editCards = (id) => {
    let editCard = crudDetails.filter(data => (data.id == id) )
    setcarName(editCard[0].carname);
    setModel(editCard[0].model);
    setPrice(editCard[0].price);
    setType(editCard[0].type);
    setDescription(editCard[0].description);
    setId(editCard[0].id);
    setStatus("edit");

  }

  console.log(crudDetails)

  return (
    <div className="App">

      <Box>
        <AppBar color="transparent" position="static" >
          
            <Typography variant="h6" component="div" style={{textAlign:'center', padding:'30px'}} >
              CRUD OPERATIONS USING MATERIAL USING
            </Typography>
          
        </AppBar>
      </Box> <br></br> <br></br>
      <Box style={{display: "flex", justifyContent:"center" , marginTop:"120px"}}
        sx={{
          display: 'flex',
          flexWrap: 'wrap',
          '& > :not(style)': {
            m: 1,
            width: 500,
            height: 400,},
          }}>
        
        <Paper elevation={1} style={{display:"flex" , flexDirection:"column", alignItems:"center", padding:"60px 0 60px 0", margin:"-20px 200px 0 50px"}}>
          <div>
            <TextField 
              value={carname}
              label="Car Name" 
              variant="outlined" 
              onChange={(e)=>setcarName(e.target.value)}/>
          </div><br></br>
          <div>
            <TextField 
              value={model}
              label="Model" 
              variant="outlined" 
              onChange={(e)=>setModel(e.target.value)}/>
          </div><br></br>
          <div>
            <TextField 
              value={price}
              label="Price" 
              variant="outlined" 
              onChange={(e)=>setPrice(e.target.value)}/>
          </div><br></br>
          <div>
            <Box sx={{ minWidth: 195 }}>
            <FormControl fullWidth >
              <InputLabel>type</InputLabel>
              <Select
                value={type}
                label="Type"
                variant="outlined" 
                onChange={(e)=>setType(e.target.value)}
              >
                <MenuItem value="Petrol">Petrol</MenuItem>
                <MenuItem value="Diesel">Diesel</MenuItem>
                <MenuItem value="Electric">Electric</MenuItem>
              </Select>
            </FormControl>
            </Box>
          </div><br></br>
            
          <div>
            <TextField 
              value={description}
              label="Description" 
              variant="outlined"
              onChange={(e)=>setDescription(e.target.value)}/>
          </div><br></br>
          
          <div>
            <Button 
              variant="contained" 
              color="success"
              onClick = {()=>submit()}
              >Submit
            </Button>
          </div>

        </Paper>
           {
              crudDetails && crudDetails.map(eachDetail => {
                return (
                  <Card sx={{maxWidth: 350}}>
                    
                    <CardMedia
                      component="img"
                      height="200"
                      image='https://cdn-ds.com/blogs-media/sites/178/2018/11/12085959/2019-MB-AMG-GT-exterior-front-fascia-going-fast-on-blurred-road_o-1038x375.jpg'
                      alt="bmw"/>

                      <CardContent>
                
                
                        <div>
                          <Typography>
                            {eachDetail.carname} 
                          </Typography>
                          <Typography>
                            {eachDetail.model}
                          </Typography>
                          <Typography>
                            {eachDetail.price}
                          </Typography>
                          <Typography>
                            {eachDetail.type}
                          </Typography>
                          <Typography>
                            {eachDetail.description}
                          </Typography>
                        </div>
                        
                    
                      </CardContent>
                     <div style={{display: "flex",margin:'0 15px 20px 10px', flexDirection:"row-reverse"}}>
                      <Button 
                        variant="contained" 
                        color="success"
                        onClick = {()=>deleteCards(eachDetail.id)}
                        >Delete
                      </Button> 
                      <Button style={{margin:'0 10px 0 20px'}} 
                        variant="contained" 
                        color="primary"
                        onClick = {()=>editCards(eachDetail.id)}
                        >Edit
                      </Button>
                    </div>
                    
                  </Card>
                ) 
                })
            }
          
      </Box>
      


      
    </div>
  );
}

export default App;
