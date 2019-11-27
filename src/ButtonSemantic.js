import React from 'react';
import {Button} from 'semantic-ui-react';


class ButtonSemantic extends React.Component{
    state = {

    }


    render(){
        return(
            <div>
            <Button circular color='facebook' icon='facebook' />
            <Button circular color='instagram' icon='instagram' />
    <Button circular color='twitter' icon='twitter' />
    <Button circular color='linkedin' icon='linkedin' />
    <Button circular color='google plus' icon='google plus' />
   
    </div>
        );
    };
}


export default ButtonSemantic;