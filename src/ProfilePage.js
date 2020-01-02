import React from 'react';
import GLOBAL from './global';
import axios from 'axios';
import Image from 'react-bootstrap/Image';

class ProfilePage extends React.Component{

    state = {
        students: []
      }
    
    

    render(){
        return(
            <div textAlign="center" verticalAlign="middle" style={{height: "800px", backgroundColor: "gray"}}>
                 <Image src="holder.js/171x180" roundedCircle />
                

              


            </div>



        );


    };

}

export default ProfilePage;