const initialState=['Anand','Palanisamy']

const Reducer=(state,action)=>{
  
  const inter=[action.event,action.event]
  
   switch(action.type){
       case 'Update-details':
          return inter; 
          
        default:
          return initialState;
   }
   
};

export default Reducer;

