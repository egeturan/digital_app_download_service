import React from 'react';
import './App.css';
import NavigationBar from './NavigationAda';
import AppRenderer from './AppRenderer';


class App extends React.Component {

  state = {
    showDisplay: 0
  };



  render(){

    let homePage= (
      <div>
        
      </div>
  
    );

    return (



      <div>
      <NavigationBar ></NavigationBar>
      <AppRenderer></AppRenderer>
  
  
  
      </div>
    );
  
  };

}

export default App;
