#RNN

#Data Pre-Processing

#Libraries
import numpy as np
import pandas as pd
import matplotlib.pyplot as plt

#Importing training set
dataset = pd.read_csv('C:/Users/SHUBHAM TOTLA/Desktop/WEATHER1.csv')
train = dataset.iloc[:,4:5].values

#Feature Scaling
from sklearn.preprocessing import MinMaxScaler
sc = MinMaxScaler(feature_range = (0,1))#All the prizes would be between 0 and 1
train_scaled = sc.fit_transform(train)

#Creating a data structre with 60 timesteps and 1 output
x_train = []
y_train = []
for i in range(24,324):
    x_train.append(train_scaled[i-24:i,0])
    y_train.append(train_scaled[i,0])
x_train, y_train = np.array(x_train), np.array(y_train)

#Reshaping
x_train = np.reshape(x_train, (x_train.shape[0], x_train.shape[1], 1))

#BUILDING THE RNN

#Importing Keras
from keras.models import Sequential
from keras.layers import Dense
from keras.layers import LSTM
from keras.layers import Dropout

#Initializing RNN
regressor = Sequential()

#Adding first layer and Dropout regularization
regressor.add(LSTM(units = 50, return_sequences = True, input_shape =  (x_train.shape[1], 1)))
regressor.add(Dropout(0.2))

#Adding second layer and Dropout regularization
regressor.add(LSTM(units = 50, return_sequences = True))
regressor.add(Dropout(0.2))

#Adding third layer and Dropout regularization
regressor.add(LSTM(units = 50, return_sequences = True))
regressor.add(Dropout(0.2))

#Adding fourth layer and Dropout regularization
regressor.add(LSTM(units = 50))
regressor.add(Dropout(0.2))

#Adding Output Layer
regressor.add(Dense(units = 1))

#Compiling RNN
regressor.compile(optimizer = 'adam', loss = 'mean_squared_error')#Stochastic Gradient descent

# Fitting the RNN to the Training set
regressor.fit(x_train, y_train, epochs = 100, batch_size= 32  )

#MAKING PREDICTIONS

data_test = pd.read_csv('C:/Users/SHUBHAM TOTLA/Desktop/weather2.csv')
real_pressure = data_test.iloc[:,4:5].values

#Getting Pressure
dataset_total = pd.concat((dataset['ABSOLUTE PRESSURE'], data_test['ATM PRESSURE']), axis = 0)
inputs = dataset_total[len(dataset_total) - len(data_test) - 24: ].values
inputs = inputs.reshape(-1 ,1)# It will put everything in one clolumn since we didn't use iloc
inputs = sc.transform(inputs)
x_test = []
for i in range(24, 52):
    x_test.append(inputs[i-24:i,0])
x_test = np.array(x_test)
x_test = np.reshape(x_test, (x_test.shape[0], x_test.shape[1], 1))
predicted_pressure = regressor.predict(x_test)
predicted_pressure = sc.inverse_transform(predicted_pressure)

# Visualising the results
plt.plot(real_pressure, color = 'red', label = 'Real Pressure')
plt.plot(predicted_pressure, color = 'blue', label = 'Predicted Pressure')
plt.title('Pressure Prediction')
plt.xlabel('Time')
plt.ylabel('Pressure')
plt.legend()
plt.show()

