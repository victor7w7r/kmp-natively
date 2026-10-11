package com.victor7w7r.kmpNatively.core.modules

import com.slack.circuit.foundation.Circuit
import com.slack.circuit.runtime.presenter.Presenter
import com.slack.circuit.runtime.screen.CircuitSaver
import com.slack.circuit.runtime.ui.Ui
import com.slack.circuit.serialization.CircuitSerializerRegistration
import com.slack.circuit.serialization.SerializableCircuitSaver
import dev.zacsweers.metro.*

@ContributesTo(AppScope::class)
interface CircuitModule {
  @Multibinds fun presenterFactories(): Set<Presenter.Factory>

  @Multibinds fun viewFactories(): Set<Ui.Factory>

  @Multibinds
  fun circuitSerializerRegistrations(): Set<CircuitSerializerRegistration>

  companion object {
    @Provides
    fun provideCircuitSaver(registrations: Set<CircuitSerializerRegistration>): CircuitSaver = SerializableCircuitSaver(registrations)

    @Provides
    @SingleIn(AppScope::class)
    fun provideCircuit(
      presenterFactories: Set<Presenter.Factory>,
      uiFactories: Set<Ui.Factory>,
      circuitSaver: CircuitSaver,
    ): Circuit =
      Circuit
        .Builder()
        .addPresenterFactories(presenterFactories)
        .addUiFactories(uiFactories)
        .setCircuitSaver(circuitSaver)
        .build()
  }
}
