import React from 'react';
import { Grid, Container, Divider, Dropdown, Header, Modal} from 'semantic-ui-react';
import ApplicationInformationPage from './ApplicationInformationPage';

class AppRenderer extends React.Component{

    state= {
        showDisplay: 0
    };

    changeScreen(displayOption) {
        this.setState({
            uzmanScreen: displayOption
        });
      }


    render(){
        return(
            <div>
                
                <ApplicationInformationPage></ApplicationInformationPage>


            </div>



        );


    };

}

export default AppRenderer;