import logo from '../../assets/img/logo-vn.jpg';
import './styles.css';

const FormLogin = () => {
    return (
        <div className="conteiner-logo">
            <form action="" method="post">
                <div className="img-log">
                    <img src={logo} alt="img-login" />
                    <p>Faça o seu login aqui!</p>
                </div>
                <div className="form-input">
                    <label htmlFor="email">
                        <span>E-mail :</span>
                    </label>
                    <input type="email" name="email" id="email" />
                </div>
                <div className="form-input">
                    <label htmlFor="password">
                        <span>Password :</span>
                    </label>
                    <input type="password" name="password" id="password" />
                </div>
            </form>
        </div>
    )
}

export default FormLogin;