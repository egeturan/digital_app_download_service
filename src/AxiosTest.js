import React from 'react';

import axios from 'axios';

class AxiosTest extends React.Component{

    state = {
        students: []
      }
    
      componentDidMount() {
        axios.get(`http://localhost:8080/alerts`)
          .then(response => {
            let newStudents = {students: response.data};
            console.log(newStudents);
            this.setState(newStudents);
          })
      }

    render(){
        return(
            <div style={{height: "1000px"}}>
                <h1> HTTP Request </h1>
              


            </div>



        );


    };

}

export default AxiosTest;