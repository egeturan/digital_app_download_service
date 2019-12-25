import React from 'react';
import ApplicationInformationPage from './ApplicationInformationPage';
import NavigationAda from './NavigationAda';
import HomePage from './Homepage';
import AuthenticatedNavbar from './AuthenticatedNavbar';
import GLOBAL from './global';

class AppRenderer extends React.Component{

    state= {
        showDisplay: 0,
        authenticate: 0,
        hashData: "",
        user: null
    };

    changeScreen(displayOption) {
        this.setState({
            uzmanScreen: displayOption
        });
      }

      componentDidMount(){
        if(GLOBAL.userG == null){
            console.log("It is null");
            this.setState({
                authenticate: 0
            });
        }else{
            console.log("User name is: " + GLOBAL.userG.username);
            console.log("It is not null");
            this.setState({
                authenticate: 1
            });
        }
      }


    render(){

        let render = null;

        if(this.state.authenticate == 1){
            render = (
                <div>
                <AuthenticatedNavbar> </AuthenticatedNavbar>
                <ApplicationInformationPage></ApplicationInformationPage>
                </div>
            );
        }else{
            render = (
                <div>
                <NavigationAda></NavigationAda>
                <ApplicationInformationPage></ApplicationInformationPage>
                </div>
            );
        }


        return(
            <div>
                {render}


            </div>



        );


    };

}

export default AppRenderer;